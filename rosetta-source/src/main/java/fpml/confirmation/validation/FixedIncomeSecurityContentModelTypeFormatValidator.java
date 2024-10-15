package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedIncomeSecurityContentModelTypeFormatValidator implements Validator<FixedIncomeSecurityContentModel> {

	private List<ComparisonResult> getComparisonResults(FixedIncomeSecurityContentModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("issuerName", o.getIssuerName(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<FixedIncomeSecurityContentModel> validate(RosettaPath path, FixedIncomeSecurityContentModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedIncomeSecurityContentModel", ValidationType.TYPE_FORMAT, "FixedIncomeSecurityContentModel", path, "", error);
		}
		return success("FixedIncomeSecurityContentModel", ValidationType.TYPE_FORMAT, "FixedIncomeSecurityContentModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedIncomeSecurityContentModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedIncomeSecurityContentModel", ValidationType.TYPE_FORMAT, "FixedIncomeSecurityContentModel", path, "", res.getError());
				}
				return success("FixedIncomeSecurityContentModel", ValidationType.TYPE_FORMAT, "FixedIncomeSecurityContentModel", path, "");
			})
			.collect(toList());
	}

}
