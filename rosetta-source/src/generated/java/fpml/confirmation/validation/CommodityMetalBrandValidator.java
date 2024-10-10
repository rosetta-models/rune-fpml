package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityMetalBrand;
import fpml.confirmation.CommodityMetalBrandManager;
import fpml.confirmation.CommodityMetalBrandName;
import fpml.confirmation.CommodityMetalProducer;
import fpml.confirmation.CountryCode;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityMetalBrandValidator implements Validator<CommodityMetalBrand> {

	private List<ComparisonResult> getComparisonResults(CommodityMetalBrand o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (CommodityMetalBrandName) o.getName() != null ? 1 : 0, 1, 1), 
				checkCardinality("brandManager", (CommodityMetalBrandManager) o.getBrandManager() != null ? 1 : 0, 0, 1), 
				checkCardinality("country", (CountryCode) o.getCountry() != null ? 1 : 0, 0, 1), 
				checkCardinality("producer", (CommodityMetalProducer) o.getProducer() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityMetalBrand> validate(RosettaPath path, CommodityMetalBrand o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityMetalBrand", ValidationType.CARDINALITY, "CommodityMetalBrand", path, "", error);
		}
		return success("CommodityMetalBrand", ValidationType.CARDINALITY, "CommodityMetalBrand", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMetalBrand o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMetalBrand", ValidationType.CARDINALITY, "CommodityMetalBrand", path, "", res.getError());
				}
				return success("CommodityMetalBrand", ValidationType.CARDINALITY, "CommodityMetalBrand", path, "");
			})
			.collect(toList());
	}

}
