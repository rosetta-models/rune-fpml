package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NetAndOrGrossModelSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NetAndOrGrossModelSequenceValidator implements Validator<NetAndOrGrossModelSequence> {

	private List<ComparisonResult> getComparisonResults(NetAndOrGrossModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("gross", (BigDecimal) o.getGross() != null ? 1 : 0, 1, 1), 
				checkCardinality("net", (BigDecimal) o.getNet() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NetAndOrGrossModelSequence> validate(RosettaPath path, NetAndOrGrossModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NetAndOrGrossModelSequence", ValidationType.CARDINALITY, "NetAndOrGrossModelSequence", path, "", error);
		}
		return success("NetAndOrGrossModelSequence", ValidationType.CARDINALITY, "NetAndOrGrossModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NetAndOrGrossModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NetAndOrGrossModelSequence", ValidationType.CARDINALITY, "NetAndOrGrossModelSequence", path, "", res.getError());
				}
				return success("NetAndOrGrossModelSequence", ValidationType.CARDINALITY, "NetAndOrGrossModelSequence", path, "");
			})
			.collect(toList());
	}

}
