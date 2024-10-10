package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyPortfolioName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyPortfolioNameTypeFormatValidator implements Validator<PartyPortfolioName> {

	private List<ComparisonResult> getComparisonResults(PartyPortfolioName o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartyPortfolioName> validate(RosettaPath path, PartyPortfolioName o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyPortfolioName", ValidationType.TYPE_FORMAT, "PartyPortfolioName", path, "", error);
		}
		return success("PartyPortfolioName", ValidationType.TYPE_FORMAT, "PartyPortfolioName", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyPortfolioName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyPortfolioName", ValidationType.TYPE_FORMAT, "PartyPortfolioName", path, "", res.getError());
				}
				return success("PartyPortfolioName", ValidationType.TYPE_FORMAT, "PartyPortfolioName", path, "");
			})
			.collect(toList());
	}

}
