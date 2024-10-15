package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbsoluteTolerance;
import fpml.confirmation.PartyReference;
import fpml.confirmation.QuantityUnit;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbsoluteToleranceValidator implements Validator<AbsoluteTolerance> {

	private List<ComparisonResult> getComparisonResults(AbsoluteTolerance o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("positive", (BigDecimal) o.getPositive() != null ? 1 : 0, 1, 1), 
				checkCardinality("negative", (BigDecimal) o.getNegative() != null ? 1 : 0, 1, 1), 
				checkCardinality("unit", (QuantityUnit) o.getUnit() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionOwnerPartyReference", (PartyReference) o.getOptionOwnerPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AbsoluteTolerance> validate(RosettaPath path, AbsoluteTolerance o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbsoluteTolerance", ValidationType.CARDINALITY, "AbsoluteTolerance", path, "", error);
		}
		return success("AbsoluteTolerance", ValidationType.CARDINALITY, "AbsoluteTolerance", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbsoluteTolerance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbsoluteTolerance", ValidationType.CARDINALITY, "AbsoluteTolerance", path, "", res.getError());
				}
				return success("AbsoluteTolerance", ValidationType.CARDINALITY, "AbsoluteTolerance", path, "");
			})
			.collect(toList());
	}

}
