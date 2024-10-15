package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.CommodityExpireRelativeToEvent;
import fpml.confirmation.CommodityRelativeExpirationDates;
import fpml.confirmation.DateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityRelativeExpirationDatesValidator implements Validator<CommodityRelativeExpirationDates> {

	private List<ComparisonResult> getComparisonResults(CommodityRelativeExpirationDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expireRelativeToEvent", (CommodityExpireRelativeToEvent) o.getExpireRelativeToEvent() != null ? 1 : 0, 1, 1), 
				checkCardinality("expirationDateOffset", (DateOffset) o.getExpirationDateOffset() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCentersOrReferenceModel", (BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityRelativeExpirationDates> validate(RosettaPath path, CommodityRelativeExpirationDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityRelativeExpirationDates", ValidationType.CARDINALITY, "CommodityRelativeExpirationDates", path, "", error);
		}
		return success("CommodityRelativeExpirationDates", ValidationType.CARDINALITY, "CommodityRelativeExpirationDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativeExpirationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityRelativeExpirationDates", ValidationType.CARDINALITY, "CommodityRelativeExpirationDates", path, "", res.getError());
				}
				return success("CommodityRelativeExpirationDates", ValidationType.CARDINALITY, "CommodityRelativeExpirationDates", path, "");
			})
			.collect(toList());
	}

}
