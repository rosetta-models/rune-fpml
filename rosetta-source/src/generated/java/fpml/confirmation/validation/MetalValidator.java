package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMetalGrade;
import fpml.confirmation.CommodityMetalShape;
import fpml.confirmation.Material;
import fpml.confirmation.Metal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MetalValidator implements Validator<Metal> {

	private List<ComparisonResult> getComparisonResults(Metal o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("material", (Material) o.getMaterial() != null ? 1 : 0, 1, 1), 
				checkCardinality("shape", (List<? extends CommodityMetalShape>) o.getShape() == null ? 0 : ((List<? extends CommodityMetalShape>) o.getShape()).size(), 1, 0), 
				checkCardinality("grade", (List<? extends CommodityMetalGrade>) o.getGrade() == null ? 0 : ((List<? extends CommodityMetalGrade>) o.getGrade()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<Metal> validate(RosettaPath path, Metal o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Metal", ValidationType.CARDINALITY, "Metal", path, "", error);
		}
		return success("Metal", ValidationType.CARDINALITY, "Metal", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Metal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Metal", ValidationType.CARDINALITY, "Metal", path, "", res.getError());
				}
				return success("Metal", ValidationType.CARDINALITY, "Metal", path, "");
			})
			.collect(toList());
	}

}
