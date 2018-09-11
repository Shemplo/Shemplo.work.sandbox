package me.shemplo.math.timeline.event;

import static me.shemplo.math.timeline.gfx.AppIconEnum.*;

import me.shemplo.math.timeline.gfx.AppIconEnum;

public enum MathEvent {

    _00  (-4000, null,    "������������� ������������"),
    _01  (-3000, LETTER,  "���������� ���������"),
    _02  (-600,  ANGLE,   "������������ ���������"),
    _03  (-360,  EARTH,   "�������������� �������������� �����"),
    _04  (-340,  null,    "���������� ������"),
    _05  (-330,  null,    "������������������ ����� ��� ����������� ���������� �� ������ � ����"),
    _06  (-300,  ANGLE,   "����������� ���������"),
    _07  (820,   null,    "������� ��� ��������������� �����"),
    _08  (1380,  null,    "������ ������������� ���������� ������"),
    _09  (1539,  null,    "������� ��������� ����������� ���������"),
    _10  (1540,  null,    "������� ��������� �������� �������"),
    _11  (1572,  null,    "�������������� �������� ��� ������������ �������"),
    _12  (1580,  LETTER,  "������������� �������"),
    _13  (1585,  null,    "�������������� �������� � ����������� �������"),
    _131 (1595,  null,    "������ �������������"),
    _14  (1614,  null,    "���������"),
    _15  (1617,  null,    "���������� ���������"),
    _16  (1637,  null,    "������������� ���������"),
    _17  (1657,  null,    "������ ������ ������������"),
    _18  (1682,  null,    "���������������� � ������������ ����������"),
    _19  (1694,  null,    "���������������� ���������"),
    _20  (1696,  null,    "������� ��������"),
    _21  (1736,  null,    "������ ������ ������, ������ � �������������� ������"),
    _22  (1748,  null,    "��������������� ���������� ��������������� �������"),
    _23  (1750,  LETTER,  "������ �������� �������"),
    _24  (1780,  null,    "������������ ����������"),
    _25  (1799,  null,    "�������� ������� �������"),
    _26  (1822,  null,    "�������������� �����"),
    _27  (1823,  FORMULA, "������ ��������������� �������"),
    _28  (1824,  null,    "�������������� ������������� �������������� ������� ������ ��������� ����� ������� � ����"),
    _29  (1826,  ANGLE,   "����������� ���������"),
    _30  (1827,  null,    "���������� ��������� ������������"),
    _31  (1832,  null,    "���������� �������� ��������� ����� � ������ ��������"),
    _32  (1847,  null,    "������ ������� �������"),
    _33  (1854,  null,    "������ n-������ ������ �����������"),
    _34  (1859,  null,    "������������ ������"),
    _35  (1883,  null,    "�������� ��������� ���������, ������ ��������� �������"),
    _36  (1948,  null,    "��������� ����� �����������")
    ;
    
    public final AppIconEnum ICON;
    public final String EVENT;
    public final int YEAR;
    
    private MathEvent (int year, AppIconEnum icon, String event) {
        this.EVENT = event; this.ICON = icon; this.YEAR = year;
    }
    
}
