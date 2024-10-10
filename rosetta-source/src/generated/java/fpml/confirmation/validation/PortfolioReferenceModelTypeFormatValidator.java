package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PortfolioReferenceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PortfolioReferenceModelTypeFormatValidator implements Validator<PortfolioReferenceModel> {

	private List<ComparisonResult> getComparisonResults(PortfolioReferenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PortfolioReferenceModel> validate(RosettaPath path, PortfolioReferenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PortfolioReferenceModel", ValidationType.TYPE_FORMAT, "PortfolioReferenceModel", path, "", error);
		}
		return success("PortfolioReferenceModel", ValidationType.TYPE_FORMAT, "PortfolioReferenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioReferenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioReferenceModel", ValidationType.TYPE_FORMAT, "PortfolioReferenceModel", path, "", res.getError());
				}
				return success("PortfolioReferenceModel", ValidationType.TYPE_FORMAT, "PortfolioReferenceModel", path, "");
			})
			.collect(toList());
	}

}
