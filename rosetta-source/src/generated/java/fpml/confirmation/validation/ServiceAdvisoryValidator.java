package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ServiceAdvisory;
import fpml.confirmation.ServiceAdvisoryCategory;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ServiceAdvisoryValidator implements Validator<ServiceAdvisory> {

	private List<ComparisonResult> getComparisonResults(ServiceAdvisory o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("category", (ServiceAdvisoryCategory) o.getCategory() != null ? 1 : 0, 1, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveFrom", (ZonedDateTime) o.getEffectiveFrom() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveTo", (ZonedDateTime) o.getEffectiveTo() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ServiceAdvisory> validate(RosettaPath path, ServiceAdvisory o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ServiceAdvisory", ValidationType.CARDINALITY, "ServiceAdvisory", path, "", error);
		}
		return success("ServiceAdvisory", ValidationType.CARDINALITY, "ServiceAdvisory", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceAdvisory o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ServiceAdvisory", ValidationType.CARDINALITY, "ServiceAdvisory", path, "", res.getError());
				}
				return success("ServiceAdvisory", ValidationType.CARDINALITY, "ServiceAdvisory", path, "");
			})
			.collect(toList());
	}

}
