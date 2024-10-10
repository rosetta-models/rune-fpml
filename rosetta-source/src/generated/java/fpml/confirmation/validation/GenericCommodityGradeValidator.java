package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericCommodityGrade;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericCommodityGradeValidator implements Validator<GenericCommodityGrade> {

	private List<ComparisonResult> getComparisonResults(GenericCommodityGrade o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityGradeScheme", (String) o.getCommodityGradeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericCommodityGrade> validate(RosettaPath path, GenericCommodityGrade o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericCommodityGrade", ValidationType.CARDINALITY, "GenericCommodityGrade", path, "", error);
		}
		return success("GenericCommodityGrade", ValidationType.CARDINALITY, "GenericCommodityGrade", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericCommodityGrade o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericCommodityGrade", ValidationType.CARDINALITY, "GenericCommodityGrade", path, "", res.getError());
				}
				return success("GenericCommodityGrade", ValidationType.CARDINALITY, "GenericCommodityGrade", path, "");
			})
			.collect(toList());
	}

}
