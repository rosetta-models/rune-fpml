package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFrequencyType;
import fpml.confirmation.DaysModelSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DaysModelSequence0Validator implements Validator<DaysModelSequence0> {

	private List<ComparisonResult> getComparisonResults(DaysModelSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dayDistribution", (CommodityFrequencyType) o.getDayDistribution() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCount", (Integer) o.getDayCount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DaysModelSequence0> validate(RosettaPath path, DaysModelSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DaysModelSequence0", ValidationType.CARDINALITY, "DaysModelSequence0", path, "", error);
		}
		return success("DaysModelSequence0", ValidationType.CARDINALITY, "DaysModelSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DaysModelSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DaysModelSequence0", ValidationType.CARDINALITY, "DaysModelSequence0", path, "", res.getError());
				}
				return success("DaysModelSequence0", ValidationType.CARDINALITY, "DaysModelSequence0", path, "");
			})
			.collect(toList());
	}

}
