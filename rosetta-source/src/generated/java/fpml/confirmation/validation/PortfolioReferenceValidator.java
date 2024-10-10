package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PortfolioName;
import fpml.confirmation.PortfolioReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PortfolioReferenceValidator implements Validator<PortfolioReference> {

	private List<ComparisonResult> getComparisonResults(PortfolioReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("portfolioName", (PortfolioName) o.getPortfolioName() != null ? 1 : 0, 1, 1), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 1, 1), 
				checkCardinality("submissionsComplete", (Boolean) o.getSubmissionsComplete() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PortfolioReference> validate(RosettaPath path, PortfolioReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PortfolioReference", ValidationType.CARDINALITY, "PortfolioReference", path, "", error);
		}
		return success("PortfolioReference", ValidationType.CARDINALITY, "PortfolioReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioReference", ValidationType.CARDINALITY, "PortfolioReference", path, "", res.getError());
				}
				return success("PortfolioReference", ValidationType.CARDINALITY, "PortfolioReference", path, "");
			})
			.collect(toList());
	}

}
