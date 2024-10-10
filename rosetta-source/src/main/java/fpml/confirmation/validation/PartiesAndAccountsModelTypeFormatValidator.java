package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartiesAndAccountsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartiesAndAccountsModelTypeFormatValidator implements Validator<PartiesAndAccountsModel> {

	private List<ComparisonResult> getComparisonResults(PartiesAndAccountsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartiesAndAccountsModel> validate(RosettaPath path, PartiesAndAccountsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartiesAndAccountsModel", ValidationType.TYPE_FORMAT, "PartiesAndAccountsModel", path, "", error);
		}
		return success("PartiesAndAccountsModel", ValidationType.TYPE_FORMAT, "PartiesAndAccountsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartiesAndAccountsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartiesAndAccountsModel", ValidationType.TYPE_FORMAT, "PartiesAndAccountsModel", path, "", res.getError());
				}
				return success("PartiesAndAccountsModel", ValidationType.TYPE_FORMAT, "PartiesAndAccountsModel", path, "");
			})
			.collect(toList());
	}

}
