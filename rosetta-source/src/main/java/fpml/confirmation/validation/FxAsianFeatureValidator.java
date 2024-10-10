package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxAsianFeature;
import fpml.confirmation.FxAsianFeatureSequence;
import fpml.confirmation.FxRateObservationModel;
import fpml.confirmation.InformationSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAsianFeatureValidator implements Validator<FxAsianFeature> {

	private List<ComparisonResult> getComparisonResults(FxAsianFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("primaryRateSource", (InformationSource) o.getPrimaryRateSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("secondaryRateSource", (InformationSource) o.getSecondaryRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxAsianFeatureSequence", (FxAsianFeatureSequence) o.getFxAsianFeatureSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxRateObservationModel", (FxRateObservationModel) o.getFxRateObservationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoutFormula", (String) o.getPayoutFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("precision", (Integer) o.getPrecision() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAsianFeature> validate(RosettaPath path, FxAsianFeature o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAsianFeature", ValidationType.CARDINALITY, "FxAsianFeature", path, "", error);
		}
		return success("FxAsianFeature", ValidationType.CARDINALITY, "FxAsianFeature", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAsianFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAsianFeature", ValidationType.CARDINALITY, "FxAsianFeature", path, "", res.getError());
				}
				return success("FxAsianFeature", ValidationType.CARDINALITY, "FxAsianFeature", path, "");
			})
			.collect(toList());
	}

}
