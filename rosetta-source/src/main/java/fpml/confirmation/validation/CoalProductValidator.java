package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalProduct;
import fpml.confirmation.CoalProductSource;
import fpml.confirmation.CoalProductSpecifications;
import fpml.confirmation.CoalProductType;
import fpml.confirmation.CommodityUSCoalProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalProductValidator implements Validator<CoalProduct> {

	private List<ComparisonResult> getComparisonResults(CoalProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("_type", (CoalProductType) o.get_type() != null ? 1 : 0, 0, 1), 
				checkCardinality("coalProductSpecifications", (CoalProductSpecifications) o.getCoalProductSpecifications() != null ? 1 : 0, 0, 1), 
				checkCardinality("source", (List<? extends CoalProductSource>) o.getSource() == null ? 0 : ((List<? extends CoalProductSource>) o.getSource()).size(), 1, 0), 
				checkCardinality("sCoTASpecifications", (Boolean) o.getSCoTASpecifications() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityUSCoalProductModel", (CommodityUSCoalProductModel) o.getCommodityUSCoalProductModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CoalProduct> validate(RosettaPath path, CoalProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalProduct", ValidationType.CARDINALITY, "CoalProduct", path, "", error);
		}
		return success("CoalProduct", ValidationType.CARDINALITY, "CoalProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalProduct", ValidationType.CARDINALITY, "CoalProduct", path, "", res.getError());
				}
				return success("CoalProduct", ValidationType.CARDINALITY, "CoalProduct", path, "");
			})
			.collect(toList());
	}

}
