package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ContractId;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.VersionedContractId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VersionedContractIdValidator implements Validator<VersionedContractId> {

	private List<ComparisonResult> getComparisonResults(VersionedContractId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("contractId", (ContractId) o.getContractId() != null ? 1 : 0, 1, 1), 
				checkCardinality("versionHistoryModel", (VersionHistoryModel) o.getVersionHistoryModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<VersionedContractId> validate(RosettaPath path, VersionedContractId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VersionedContractId", ValidationType.CARDINALITY, "VersionedContractId", path, "", error);
		}
		return success("VersionedContractId", ValidationType.CARDINALITY, "VersionedContractId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VersionedContractId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VersionedContractId", ValidationType.CARDINALITY, "VersionedContractId", path, "", res.getError());
				}
				return success("VersionedContractId", ValidationType.CARDINALITY, "VersionedContractId", path, "");
			})
			.collect(toList());
	}

}
