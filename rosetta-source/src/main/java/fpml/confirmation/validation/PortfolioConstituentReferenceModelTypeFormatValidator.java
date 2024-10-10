package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PortfolioConstituentReferenceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PortfolioConstituentReferenceModelTypeFormatValidator implements Validator<PortfolioConstituentReferenceModel> {

	private List<ComparisonResult> getComparisonResults(PortfolioConstituentReferenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PortfolioConstituentReferenceModel> validate(RosettaPath path, PortfolioConstituentReferenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PortfolioConstituentReferenceModel", ValidationType.TYPE_FORMAT, "PortfolioConstituentReferenceModel", path, "", error);
		}
		return success("PortfolioConstituentReferenceModel", ValidationType.TYPE_FORMAT, "PortfolioConstituentReferenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioConstituentReferenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioConstituentReferenceModel", ValidationType.TYPE_FORMAT, "PortfolioConstituentReferenceModel", path, "", res.getError());
				}
				return success("PortfolioConstituentReferenceModel", ValidationType.TYPE_FORMAT, "PortfolioConstituentReferenceModel", path, "");
			})
			.collect(toList());
	}

}
