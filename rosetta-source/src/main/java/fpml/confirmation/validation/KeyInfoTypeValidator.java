package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.KeyInfoType;
import fpml.confirmation.KeyInfoTypeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class KeyInfoTypeValidator implements Validator<KeyInfoType> {

	private List<ComparisonResult> getComparisonResults(KeyInfoType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("keyInfoTypeChoice", (List<? extends KeyInfoTypeChoice>) o.getKeyInfoTypeChoice() == null ? 0 : ((List<? extends KeyInfoTypeChoice>) o.getKeyInfoTypeChoice()).size(), 1, 0), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<KeyInfoType> validate(RosettaPath path, KeyInfoType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("KeyInfoType", ValidationType.CARDINALITY, "KeyInfoType", path, "", error);
		}
		return success("KeyInfoType", ValidationType.CARDINALITY, "KeyInfoType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyInfoType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("KeyInfoType", ValidationType.CARDINALITY, "KeyInfoType", path, "", res.getError());
				}
				return success("KeyInfoType", ValidationType.CARDINALITY, "KeyInfoType", path, "");
			})
			.collect(toList());
	}

}
