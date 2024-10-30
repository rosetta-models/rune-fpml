package cdm.margin.schedule.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(AdjustableOrAdjustedOrRelativeDateResolution.AdjustableOrAdjustedOrRelativeDateResolutionDefault.class)
public abstract class AdjustableOrAdjustedOrRelativeDateResolution implements RosettaFunction {

	/**
	* @param adjustableDate 
	* @return date 
	*/
	public Date evaluate(AdjustableOrAdjustedOrRelativeDate adjustableDate) {
		Date date = doEvaluate(adjustableDate);
		
		return date;
	}

	protected abstract Date doEvaluate(AdjustableOrAdjustedOrRelativeDate adjustableDate);

	public static class AdjustableOrAdjustedOrRelativeDateResolutionDefault extends AdjustableOrAdjustedOrRelativeDateResolution {
		@Override
		protected Date doEvaluate(AdjustableOrAdjustedOrRelativeDate adjustableDate) {
			Date date = null;
			return assignOutput(date, adjustableDate);
		}
		
		protected Date assignOutput(Date date, AdjustableOrAdjustedOrRelativeDate adjustableDate) {
			if (exists(MapperS.of(adjustableDate).<Date>map("getUnadjustedDate", adjustableOrAdjustedOrRelativeDate -> adjustableOrAdjustedOrRelativeDate.getUnadjustedDate())).getOrDefault(false)) {
				date = MapperS.of(adjustableDate).<Date>map("getUnadjustedDate", adjustableOrAdjustedOrRelativeDate -> adjustableOrAdjustedOrRelativeDate.getUnadjustedDate()).get();
			} else {
				date = MapperS.of(adjustableDate).<FieldWithMetaDate>map("getAdjustedDate", adjustableOrAdjustedOrRelativeDate -> adjustableOrAdjustedOrRelativeDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()).get();
			}
			
			return date;
		}
	}
}
