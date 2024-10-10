package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FallbackReferencePriceType;
import fpml.confirmation.PriceSourceDisruptionType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PriceSourceDisruptionTypeValidator implements Validator<PriceSourceDisruptionType> {

	private List<ComparisonResult> getComparisonResults(PriceSourceDisruptionType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fallbackReferencePrice", (FallbackReferencePriceType) o.getFallbackReferencePrice() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PriceSourceDisruptionType> validate(RosettaPath path, PriceSourceDisruptionType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PriceSourceDisruptionType", ValidationType.CARDINALITY, "PriceSourceDisruptionType", path, "", error);
		}
		return success("PriceSourceDisruptionType", ValidationType.CARDINALITY, "PriceSourceDisruptionType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSourceDisruptionType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceSourceDisruptionType", ValidationType.CARDINALITY, "PriceSourceDisruptionType", path, "", res.getError());
				}
				return success("PriceSourceDisruptionType", ValidationType.CARDINALITY, "PriceSourceDisruptionType", path, "");
			})
			.collect(toList());
	}

}
