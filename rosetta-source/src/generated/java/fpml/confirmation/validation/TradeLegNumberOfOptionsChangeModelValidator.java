package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NumberOfOptionsReference;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeLegNumberOfOptionsChangeModelValidator implements Validator<TradeLegNumberOfOptionsChangeModel> {

	private List<ComparisonResult> getComparisonResults(TradeLegNumberOfOptionsChangeModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("numberOfOptionsReference", (NumberOfOptionsReference) o.getNumberOfOptionsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeInNumberOfOptions", (BigDecimal) o.getChangeInNumberOfOptions() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingNumberOfOptions", (BigDecimal) o.getOutstandingNumberOfOptions() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeLegNumberOfOptionsChangeModel> validate(RosettaPath path, TradeLegNumberOfOptionsChangeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeLegNumberOfOptionsChangeModel", ValidationType.CARDINALITY, "TradeLegNumberOfOptionsChangeModel", path, "", error);
		}
		return success("TradeLegNumberOfOptionsChangeModel", ValidationType.CARDINALITY, "TradeLegNumberOfOptionsChangeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegNumberOfOptionsChangeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegNumberOfOptionsChangeModel", ValidationType.CARDINALITY, "TradeLegNumberOfOptionsChangeModel", path, "", res.getError());
				}
				return success("TradeLegNumberOfOptionsChangeModel", ValidationType.CARDINALITY, "TradeLegNumberOfOptionsChangeModel", path, "");
			})
			.collect(toList());
	}

}
