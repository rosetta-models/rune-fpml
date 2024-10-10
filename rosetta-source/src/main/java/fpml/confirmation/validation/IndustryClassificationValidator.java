package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IndustryClassification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IndustryClassificationValidator implements Validator<IndustryClassification> {

	private List<ComparisonResult> getComparisonResults(IndustryClassification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("industryClassificationScheme", (String) o.getIndustryClassificationScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<IndustryClassification> validate(RosettaPath path, IndustryClassification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IndustryClassification", ValidationType.CARDINALITY, "IndustryClassification", path, "", error);
		}
		return success("IndustryClassification", ValidationType.CARDINALITY, "IndustryClassification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndustryClassification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndustryClassification", ValidationType.CARDINALITY, "IndustryClassification", path, "", res.getError());
				}
				return success("IndustryClassification", ValidationType.CARDINALITY, "IndustryClassification", path, "");
			})
			.collect(toList());
	}

}
