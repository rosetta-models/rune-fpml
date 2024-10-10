package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFinancialOptionModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFinancialOptionModelTypeFormatValidator implements Validator<CommodityFinancialOptionModel> {

	private List<ComparisonResult> getComparisonResults(CommodityFinancialOptionModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFinancialOptionModel> validate(RosettaPath path, CommodityFinancialOptionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFinancialOptionModel", ValidationType.TYPE_FORMAT, "CommodityFinancialOptionModel", path, "", error);
		}
		return success("CommodityFinancialOptionModel", ValidationType.TYPE_FORMAT, "CommodityFinancialOptionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFinancialOptionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFinancialOptionModel", ValidationType.TYPE_FORMAT, "CommodityFinancialOptionModel", path, "", res.getError());
				}
				return success("CommodityFinancialOptionModel", ValidationType.TYPE_FORMAT, "CommodityFinancialOptionModel", path, "");
			})
			.collect(toList());
	}

}
