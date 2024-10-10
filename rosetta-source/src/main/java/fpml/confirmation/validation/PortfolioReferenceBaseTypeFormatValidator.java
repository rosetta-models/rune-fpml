package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PortfolioReferenceBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PortfolioReferenceBaseTypeFormatValidator implements Validator<PortfolioReferenceBase> {

	private List<ComparisonResult> getComparisonResults(PortfolioReferenceBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PortfolioReferenceBase> validate(RosettaPath path, PortfolioReferenceBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PortfolioReferenceBase", ValidationType.TYPE_FORMAT, "PortfolioReferenceBase", path, "", error);
		}
		return success("PortfolioReferenceBase", ValidationType.TYPE_FORMAT, "PortfolioReferenceBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioReferenceBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioReferenceBase", ValidationType.TYPE_FORMAT, "PortfolioReferenceBase", path, "", res.getError());
				}
				return success("PortfolioReferenceBase", ValidationType.TYPE_FORMAT, "PortfolioReferenceBase", path, "");
			})
			.collect(toList());
	}

}
