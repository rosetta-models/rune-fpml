package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.EquityExpirationModelSequence;
import fpml.confirmation.TimeTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityExpirationModelSequenceValidator implements Validator<EquityExpirationModelSequence> {

	private List<ComparisonResult> getComparisonResults(EquityExpirationModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("equityExpirationTimeType", (TimeTypeEnum) o.getEquityExpirationTimeType() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityExpirationTime", (BusinessCenterTime) o.getEquityExpirationTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityExpirationModelSequence> validate(RosettaPath path, EquityExpirationModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityExpirationModelSequence", ValidationType.CARDINALITY, "EquityExpirationModelSequence", path, "", error);
		}
		return success("EquityExpirationModelSequence", ValidationType.CARDINALITY, "EquityExpirationModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExpirationModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityExpirationModelSequence", ValidationType.CARDINALITY, "EquityExpirationModelSequence", path, "", res.getError());
				}
				return success("EquityExpirationModelSequence", ValidationType.CARDINALITY, "EquityExpirationModelSequence", path, "");
			})
			.collect(toList());
	}

}
