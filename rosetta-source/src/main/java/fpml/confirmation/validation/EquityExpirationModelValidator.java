package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.EquityExpirationModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityExpirationModelValidator implements Validator<EquityExpirationModel> {

	private List<ComparisonResult> getComparisonResults(EquityExpirationModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("equityExpirationModelSequence", (EquityExpirationModelSequence) o.getEquityExpirationModelSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTimeDetermination", (DeterminationMethod) o.getExpirationTimeDetermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityExpirationModel> validate(RosettaPath path, EquityExpirationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityExpirationModel", ValidationType.CARDINALITY, "EquityExpirationModel", path, "", error);
		}
		return success("EquityExpirationModel", ValidationType.CARDINALITY, "EquityExpirationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExpirationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityExpirationModel", ValidationType.CARDINALITY, "EquityExpirationModel", path, "", res.getError());
				}
				return success("EquityExpirationModel", ValidationType.CARDINALITY, "EquityExpirationModel", path, "");
			})
			.collect(toList());
	}

}
