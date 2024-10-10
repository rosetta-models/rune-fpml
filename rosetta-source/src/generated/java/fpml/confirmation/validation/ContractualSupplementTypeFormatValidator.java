package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ContractualSupplement;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ContractualSupplementTypeFormatValidator implements Validator<ContractualSupplement> {

	private List<ComparisonResult> getComparisonResults(ContractualSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("contractualSupplementScheme", o.getContractualSupplementScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<ContractualSupplement> validate(RosettaPath path, ContractualSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ContractualSupplement", ValidationType.TYPE_FORMAT, "ContractualSupplement", path, "", error);
		}
		return success("ContractualSupplement", ValidationType.TYPE_FORMAT, "ContractualSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractualSupplement", ValidationType.TYPE_FORMAT, "ContractualSupplement", path, "", res.getError());
				}
				return success("ContractualSupplement", ValidationType.TYPE_FORMAT, "ContractualSupplement", path, "");
			})
			.collect(toList());
	}

}
