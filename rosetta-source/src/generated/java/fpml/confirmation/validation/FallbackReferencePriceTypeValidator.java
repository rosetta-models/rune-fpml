package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.Empty;
import fpml.confirmation.FallbackReferencePriceType;
import fpml.confirmation.ValuationPostponementType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FallbackReferencePriceTypeValidator implements Validator<FallbackReferencePriceType> {

	private List<ComparisonResult> getComparisonResults(FallbackReferencePriceType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("valuationPostponement", (ValuationPostponementType) o.getValuationPostponement() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackSurveyValuationPostponenment", (Empty) o.getFallbackSurveyValuationPostponenment() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAgentDetermination", (CalculationAgent) o.getCalculationAgentDetermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FallbackReferencePriceType> validate(RosettaPath path, FallbackReferencePriceType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FallbackReferencePriceType", ValidationType.CARDINALITY, "FallbackReferencePriceType", path, "", error);
		}
		return success("FallbackReferencePriceType", ValidationType.CARDINALITY, "FallbackReferencePriceType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackReferencePriceType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FallbackReferencePriceType", ValidationType.CARDINALITY, "FallbackReferencePriceType", path, "", res.getError());
				}
				return success("FallbackReferencePriceType", ValidationType.CARDINALITY, "FallbackReferencePriceType", path, "");
			})
			.collect(toList());
	}

}
