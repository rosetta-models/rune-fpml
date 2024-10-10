package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GoverningLaw;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GoverningLawValidator implements Validator<GoverningLaw> {

	private List<ComparisonResult> getComparisonResults(GoverningLaw o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("governingLawScheme", (String) o.getGoverningLawScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GoverningLaw> validate(RosettaPath path, GoverningLaw o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GoverningLaw", ValidationType.CARDINALITY, "GoverningLaw", path, "", error);
		}
		return success("GoverningLaw", ValidationType.CARDINALITY, "GoverningLaw", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GoverningLaw o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GoverningLaw", ValidationType.CARDINALITY, "GoverningLaw", path, "", res.getError());
				}
				return success("GoverningLaw", ValidationType.CARDINALITY, "GoverningLaw", path, "");
			})
			.collect(toList());
	}

}
