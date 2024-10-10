package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOffset;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.PeriodEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdjustableOffsetValidator implements Validator<AdjustableOffset> {

	private List<ComparisonResult> getComparisonResults(AdjustableOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("period", (PeriodEnum) o.getPeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayType", (DayTypeEnum) o.getDayType() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersOrReferenceModel", (BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AdjustableOffset> validate(RosettaPath path, AdjustableOffset o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdjustableOffset", ValidationType.CARDINALITY, "AdjustableOffset", path, "", error);
		}
		return success("AdjustableOffset", ValidationType.CARDINALITY, "AdjustableOffset", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableOffset", ValidationType.CARDINALITY, "AdjustableOffset", path, "", res.getError());
				}
				return success("AdjustableOffset", ValidationType.CARDINALITY, "AdjustableOffset", path, "");
			})
			.collect(toList());
	}

}
