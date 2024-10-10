package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityProductGrade;
import fpml.confirmation.OilProduct;
import fpml.confirmation.OilProductType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OilProductValidator implements Validator<OilProduct> {

	private List<ComparisonResult> getComparisonResults(OilProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (OilProductType) o.getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("grade", (CommodityProductGrade) o.getGrade() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<OilProduct> validate(RosettaPath path, OilProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OilProduct", ValidationType.CARDINALITY, "OilProduct", path, "", error);
		}
		return success("OilProduct", ValidationType.CARDINALITY, "OilProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilProduct", ValidationType.CARDINALITY, "OilProduct", path, "", res.getError());
				}
				return success("OilProduct", ValidationType.CARDINALITY, "OilProduct", path, "");
			})
			.collect(toList());
	}

}
