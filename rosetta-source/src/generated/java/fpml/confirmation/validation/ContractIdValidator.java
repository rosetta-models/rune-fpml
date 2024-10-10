package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ContractId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ContractIdValidator implements Validator<ContractId> {

	private List<ComparisonResult> getComparisonResults(ContractId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("contractIdScheme", (String) o.getContractIdScheme() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ContractId> validate(RosettaPath path, ContractId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ContractId", ValidationType.CARDINALITY, "ContractId", path, "", error);
		}
		return success("ContractId", ValidationType.CARDINALITY, "ContractId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractId", ValidationType.CARDINALITY, "ContractId", path, "", res.getError());
				}
				return success("ContractId", ValidationType.CARDINALITY, "ContractId", path, "");
			})
			.collect(toList());
	}

}
