package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BondReference;
import fpml.confirmation.SwapAdditionalTerms;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwapAdditionalTermsValidator implements Validator<SwapAdditionalTerms> {

	private List<ComparisonResult> getComparisonResults(SwapAdditionalTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("bondReference", (BondReference) o.getBondReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SwapAdditionalTerms> validate(RosettaPath path, SwapAdditionalTerms o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SwapAdditionalTerms", ValidationType.CARDINALITY, "SwapAdditionalTerms", path, "", error);
		}
		return success("SwapAdditionalTerms", ValidationType.CARDINALITY, "SwapAdditionalTerms", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwapAdditionalTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SwapAdditionalTerms", ValidationType.CARDINALITY, "SwapAdditionalTerms", path, "", res.getError());
				}
				return success("SwapAdditionalTerms", ValidationType.CARDINALITY, "SwapAdditionalTerms", path, "");
			})
			.collect(toList());
	}

}
