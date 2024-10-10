package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CollateralPartyAndAccountReferencesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CollateralPartyAndAccountReferencesModelTypeFormatValidator implements Validator<CollateralPartyAndAccountReferencesModel> {

	private List<ComparisonResult> getComparisonResults(CollateralPartyAndAccountReferencesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CollateralPartyAndAccountReferencesModel> validate(RosettaPath path, CollateralPartyAndAccountReferencesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CollateralPartyAndAccountReferencesModel", ValidationType.TYPE_FORMAT, "CollateralPartyAndAccountReferencesModel", path, "", error);
		}
		return success("CollateralPartyAndAccountReferencesModel", ValidationType.TYPE_FORMAT, "CollateralPartyAndAccountReferencesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPartyAndAccountReferencesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralPartyAndAccountReferencesModel", ValidationType.TYPE_FORMAT, "CollateralPartyAndAccountReferencesModel", path, "", res.getError());
				}
				return success("CollateralPartyAndAccountReferencesModel", ValidationType.TYPE_FORMAT, "CollateralPartyAndAccountReferencesModel", path, "");
			})
			.collect(toList());
	}

}
