package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFreightFlatRateModel;
import fpml.confirmation.FlatRateEnum;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFreightFlatRateModelValidator implements Validator<CommodityFreightFlatRateModel> {

	private List<ComparisonResult> getComparisonResults(CommodityFreightFlatRateModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("flatRate", (FlatRateEnum) o.getFlatRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("flatRateAmount", (NonNegativeMoney) o.getFlatRateAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityFreightFlatRateModel> validate(RosettaPath path, CommodityFreightFlatRateModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFreightFlatRateModel", ValidationType.CARDINALITY, "CommodityFreightFlatRateModel", path, "", error);
		}
		return success("CommodityFreightFlatRateModel", ValidationType.CARDINALITY, "CommodityFreightFlatRateModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFreightFlatRateModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFreightFlatRateModel", ValidationType.CARDINALITY, "CommodityFreightFlatRateModel", path, "", res.getError());
				}
				return success("CommodityFreightFlatRateModel", ValidationType.CARDINALITY, "CommodityFreightFlatRateModel", path, "");
			})
			.collect(toList());
	}

}
