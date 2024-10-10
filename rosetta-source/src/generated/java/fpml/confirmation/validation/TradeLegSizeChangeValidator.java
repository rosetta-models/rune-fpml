package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeLegFixedAmountChangeModel;
import fpml.confirmation.TradeLegNotionalChangeModel;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel;
import fpml.confirmation.TradeLegNumberOfUnitsChangeModel;
import fpml.confirmation.TradeLegSizeChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeLegSizeChangeValidator implements Validator<TradeLegSizeChange> {

	private List<ComparisonResult> getComparisonResults(TradeLegSizeChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeLegNotionalChangeModel", (TradeLegNotionalChangeModel) o.getTradeLegNotionalChangeModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeLegNumberOfOptionsChangeModel", (TradeLegNumberOfOptionsChangeModel) o.getTradeLegNumberOfOptionsChangeModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeLegNumberOfUnitsChangeModel", (TradeLegNumberOfUnitsChangeModel) o.getTradeLegNumberOfUnitsChangeModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeLegNotionalScheduleChangeModel", (TradeLegNotionalScheduleChangeModel) o.getTradeLegNotionalScheduleChangeModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeLegFixedAmountChangeModel", (TradeLegFixedAmountChangeModel) o.getTradeLegFixedAmountChangeModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeLegSizeChange> validate(RosettaPath path, TradeLegSizeChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeLegSizeChange", ValidationType.CARDINALITY, "TradeLegSizeChange", path, "", error);
		}
		return success("TradeLegSizeChange", ValidationType.CARDINALITY, "TradeLegSizeChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegSizeChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegSizeChange", ValidationType.CARDINALITY, "TradeLegSizeChange", path, "", res.getError());
				}
				return success("TradeLegSizeChange", ValidationType.CARDINALITY, "TradeLegSizeChange", path, "");
			})
			.collect(toList());
	}

}
