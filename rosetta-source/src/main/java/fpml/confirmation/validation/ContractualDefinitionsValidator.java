package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ContractualDefinitions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ContractualDefinitionsValidator implements Validator<ContractualDefinitions> {

	private List<ComparisonResult> getComparisonResults(ContractualDefinitions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("contractualDefinitionsScheme", (String) o.getContractualDefinitionsScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ContractualDefinitions> validate(RosettaPath path, ContractualDefinitions o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ContractualDefinitions", ValidationType.CARDINALITY, "ContractualDefinitions", path, "", error);
		}
		return success("ContractualDefinitions", ValidationType.CARDINALITY, "ContractualDefinitions", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualDefinitions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractualDefinitions", ValidationType.CARDINALITY, "ContractualDefinitions", path, "", res.getError());
				}
				return success("ContractualDefinitions", ValidationType.CARDINALITY, "ContractualDefinitions", path, "");
			})
			.collect(toList());
	}

}
