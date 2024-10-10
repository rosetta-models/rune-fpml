package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualRegion;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAccrualRegionSequence0;
import fpml.confirmation.FxAccrualRegionSequence1;
import fpml.confirmation.FxRateObservableReference;
import fpml.confirmation.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionValidator implements Validator<FxAccrualRegion> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observableReference", (FxRateObservableReference) o.getObservableReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxAccrualRegionBoundModel", (FxAccrualRegionBoundModel) o.getFxAccrualRegionBoundModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxAccrualRegionSequence0", (FxAccrualRegionSequence0) o.getFxAccrualRegionSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (Date) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualFactor", (Schedule) o.getAccrualFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxAccrualRegionSequence1", (FxAccrualRegionSequence1) o.getFxAccrualRegionSequence1() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualRegion> validate(RosettaPath path, FxAccrualRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegion", ValidationType.CARDINALITY, "FxAccrualRegion", path, "", error);
		}
		return success("FxAccrualRegion", ValidationType.CARDINALITY, "FxAccrualRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegion", ValidationType.CARDINALITY, "FxAccrualRegion", path, "", res.getError());
				}
				return success("FxAccrualRegion", ValidationType.CARDINALITY, "FxAccrualRegion", path, "");
			})
			.collect(toList());
	}

}
