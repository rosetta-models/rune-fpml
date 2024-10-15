package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityForwardLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityForwardLegValidator implements Validator<CommodityForwardLeg> {

	private List<ComparisonResult> getComparisonResults(CommodityForwardLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityForwardLeg> validate(RosettaPath path, CommodityForwardLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityForwardLeg", ValidationType.CARDINALITY, "CommodityForwardLeg", path, "", error);
		}
		return success("CommodityForwardLeg", ValidationType.CARDINALITY, "CommodityForwardLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityForwardLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityForwardLeg", ValidationType.CARDINALITY, "CommodityForwardLeg", path, "", res.getError());
				}
				return success("CommodityForwardLeg", ValidationType.CARDINALITY, "CommodityForwardLeg", path, "");
			})
			.collect(toList());
	}

}
