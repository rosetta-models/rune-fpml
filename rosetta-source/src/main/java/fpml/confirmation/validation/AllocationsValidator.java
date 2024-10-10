package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Allocation;
import fpml.confirmation.Allocations;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AllocationsValidator implements Validator<Allocations> {

	private List<ComparisonResult> getComparisonResults(Allocations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allocatingPartyReference", (PartyReference) o.getAllocatingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocation", (List<? extends Allocation>) o.getAllocation() == null ? 0 : ((List<? extends Allocation>) o.getAllocation()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<Allocations> validate(RosettaPath path, Allocations o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Allocations", ValidationType.CARDINALITY, "Allocations", path, "", error);
		}
		return success("Allocations", ValidationType.CARDINALITY, "Allocations", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Allocations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Allocations", ValidationType.CARDINALITY, "Allocations", path, "", res.getError());
				}
				return success("Allocations", ValidationType.CARDINALITY, "Allocations", path, "");
			})
			.collect(toList());
	}

}
