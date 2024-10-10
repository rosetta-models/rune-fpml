package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityHubCode;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityHubCodeValidator implements Validator<CommodityHubCode> {

	private List<ComparisonResult> getComparisonResults(CommodityHubCode o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("hubCodeScheme", (String) o.getHubCodeScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityHubCode> validate(RosettaPath path, CommodityHubCode o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityHubCode", ValidationType.CARDINALITY, "CommodityHubCode", path, "", error);
		}
		return success("CommodityHubCode", ValidationType.CARDINALITY, "CommodityHubCode", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityHubCode o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityHubCode", ValidationType.CARDINALITY, "CommodityHubCode", path, "", res.getError());
				}
				return success("CommodityHubCode", ValidationType.CARDINALITY, "CommodityHubCode", path, "");
			})
			.collect(toList());
	}

}
