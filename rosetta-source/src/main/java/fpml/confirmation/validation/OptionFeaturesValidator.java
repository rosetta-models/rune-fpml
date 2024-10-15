package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Asian;
import fpml.confirmation.Barrier;
import fpml.confirmation.DividendAdjustment;
import fpml.confirmation.Knock;
import fpml.confirmation.OptionFeatures;
import fpml.confirmation.PassThrough;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionFeaturesValidator implements Validator<OptionFeatures> {

	private List<ComparisonResult> getComparisonResults(OptionFeatures o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("asian", (Asian) o.getAsian() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrier", (Barrier) o.getBarrier() != null ? 1 : 0, 0, 1), 
				checkCardinality("knock", (Knock) o.getKnock() != null ? 1 : 0, 0, 1), 
				checkCardinality("passThrough", (PassThrough) o.getPassThrough() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendAdjustment", (DividendAdjustment) o.getDividendAdjustment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionFeatures> validate(RosettaPath path, OptionFeatures o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionFeatures", ValidationType.CARDINALITY, "OptionFeatures", path, "", error);
		}
		return success("OptionFeatures", ValidationType.CARDINALITY, "OptionFeatures", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionFeatures o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionFeatures", ValidationType.CARDINALITY, "OptionFeatures", path, "", res.getError());
				}
				return success("OptionFeatures", ValidationType.CARDINALITY, "OptionFeatures", path, "");
			})
			.collect(toList());
	}

}
