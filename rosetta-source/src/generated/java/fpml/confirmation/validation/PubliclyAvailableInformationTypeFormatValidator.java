package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PubliclyAvailableInformation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PubliclyAvailableInformationTypeFormatValidator implements Validator<PubliclyAvailableInformation> {

	private List<ComparisonResult> getComparisonResults(PubliclyAvailableInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("publicSource", o.getPublicSource(), 0, of(255), empty()), 
				checkNumber("specifiedNumber", o.getSpecifiedNumber(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<PubliclyAvailableInformation> validate(RosettaPath path, PubliclyAvailableInformation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PubliclyAvailableInformation", ValidationType.TYPE_FORMAT, "PubliclyAvailableInformation", path, "", error);
		}
		return success("PubliclyAvailableInformation", ValidationType.TYPE_FORMAT, "PubliclyAvailableInformation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PubliclyAvailableInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PubliclyAvailableInformation", ValidationType.TYPE_FORMAT, "PubliclyAvailableInformation", path, "", res.getError());
				}
				return success("PubliclyAvailableInformation", ValidationType.TYPE_FORMAT, "PubliclyAvailableInformation", path, "");
			})
			.collect(toList());
	}

}
