package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OrganizationType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OrganizationTypeValidator implements Validator<OrganizationType> {

	private List<ComparisonResult> getComparisonResults(OrganizationType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("organizationTypeScheme", (String) o.getOrganizationTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OrganizationType> validate(RosettaPath path, OrganizationType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OrganizationType", ValidationType.CARDINALITY, "OrganizationType", path, "", error);
		}
		return success("OrganizationType", ValidationType.CARDINALITY, "OrganizationType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganizationType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganizationType", ValidationType.CARDINALITY, "OrganizationType", path, "", res.getError());
				}
				return success("OrganizationType", ValidationType.CARDINALITY, "OrganizationType", path, "");
			})
			.collect(toList());
	}

}
