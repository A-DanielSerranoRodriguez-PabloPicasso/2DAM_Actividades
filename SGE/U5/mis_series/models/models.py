# -*- coding: utf-8 -*-
from odoo import models, fields, api

class x_genero(models.Model):
    _name = "mis_series.x_genero"
    _description = "Define un género de una serie"
    # Campo mostrado en vez de la id
    _rec_name = "x_name"

    x_name = fields.Char(string="Nombre del género", required=True)
    
class x_serie(models.Model):
    _name = "mis_series.x_serie"
    _description = "Define una serie"
    _rec_name = "x_name"

    x_name = fields.Char(string="Nombre de la serie", required=True)
    x_director = fields.Char(string="Director", required=True)
    x_duracion = fields.Integer(string="Duración", required=True)
    x_fecha = fields.Date(string="Fecha de estreno", required=True)
    x_nota = fields.Integer(string="Nota", required=True)
    x_industria = fields.Selection(string="Industria", selection=[("EU","Europa"), ("US","America"), ("AS","Asia")], default="EU", required=True)
    x_genero = fields.Many2one('mis_series.x_genero', string="Género", required=True)
