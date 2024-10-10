package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.MultipleValuationDates;
import fpml.confirmation.SingleValuationDate;
import fpml.confirmation.ValuationDate;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class ValuationDateDeepPathUtil {
	public Integer chooseBusinessDays(ValuationDate valuationDate) {
		final MapperS<SingleValuationDate> singleValuationDate = MapperS.of(valuationDate).<SingleValuationDate>map("getSingleValuationDate", _valuationDate -> _valuationDate.getSingleValuationDate());
		if (exists(singleValuationDate).getOrDefault(false)) {
			return singleValuationDate.<Integer>map("getBusinessDays", _singleValuationDate -> _singleValuationDate.getBusinessDays()).get();
		}
		final MapperS<MultipleValuationDates> multipleValuationDates = MapperS.of(valuationDate).<MultipleValuationDates>map("getMultipleValuationDates", _valuationDate -> _valuationDate.getMultipleValuationDates());
		if (exists(multipleValuationDates).getOrDefault(false)) {
			return multipleValuationDates.<Integer>map("getBusinessDays", _multipleValuationDates -> _multipleValuationDates.getBusinessDays()).get();
		}
		return null;
	}
	
}
