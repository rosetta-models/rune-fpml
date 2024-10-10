package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityNonPeriodicPaymentDatesModelTypeFormatValidator implements Validator<CommodityNonPeriodicPaymentDatesModel> {

	private List<ComparisonResult> getComparisonResults(CommodityNonPeriodicPaymentDatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityNonPeriodicPaymentDatesModel> validate(RosettaPath path, CommodityNonPeriodicPaymentDatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityNonPeriodicPaymentDatesModel", ValidationType.TYPE_FORMAT, "CommodityNonPeriodicPaymentDatesModel", path, "", error);
		}
		return success("CommodityNonPeriodicPaymentDatesModel", ValidationType.TYPE_FORMAT, "CommodityNonPeriodicPaymentDatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityNonPeriodicPaymentDatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityNonPeriodicPaymentDatesModel", ValidationType.TYPE_FORMAT, "CommodityNonPeriodicPaymentDatesModel", path, "", res.getError());
				}
				return success("CommodityNonPeriodicPaymentDatesModel", ValidationType.TYPE_FORMAT, "CommodityNonPeriodicPaymentDatesModel", path, "");
			})
			.collect(toList());
	}

}
