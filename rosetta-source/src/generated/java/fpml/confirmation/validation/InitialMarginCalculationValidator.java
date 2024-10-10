package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AssetReference;
import fpml.confirmation.InitialMarginCalculation;
import fpml.confirmation.InitialMarginCalculationSequence0;
import fpml.confirmation.InitialMarginCalculationSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InitialMarginCalculationValidator implements Validator<InitialMarginCalculation> {

	private List<ComparisonResult> getComparisonResults(InitialMarginCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialMarginCalculationSequence0", (InitialMarginCalculationSequence0) o.getInitialMarginCalculationSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginCalculationSequence1", (InitialMarginCalculationSequence1) o.getInitialMarginCalculationSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("assetReference", (AssetReference) o.getAssetReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InitialMarginCalculation> validate(RosettaPath path, InitialMarginCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InitialMarginCalculation", ValidationType.CARDINALITY, "InitialMarginCalculation", path, "", error);
		}
		return success("InitialMarginCalculation", ValidationType.CARDINALITY, "InitialMarginCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialMarginCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InitialMarginCalculation", ValidationType.CARDINALITY, "InitialMarginCalculation", path, "", res.getError());
				}
				return success("InitialMarginCalculation", ValidationType.CARDINALITY, "InitialMarginCalculation", path, "");
			})
			.collect(toList());
	}

}
