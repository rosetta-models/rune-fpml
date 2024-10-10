package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PortfolioReferenceBase;
import fpml.confirmation.PortfolioReferenceBaseModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PortfolioReferenceBaseModelValidator implements Validator<PortfolioReferenceBaseModel> {

	private List<ComparisonResult> getComparisonResults(PortfolioReferenceBaseModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("portfolioReference", (PortfolioReferenceBase) o.getPortfolioReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PortfolioReferenceBaseModel> validate(RosettaPath path, PortfolioReferenceBaseModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PortfolioReferenceBaseModel", ValidationType.CARDINALITY, "PortfolioReferenceBaseModel", path, "", error);
		}
		return success("PortfolioReferenceBaseModel", ValidationType.CARDINALITY, "PortfolioReferenceBaseModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioReferenceBaseModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioReferenceBaseModel", ValidationType.CARDINALITY, "PortfolioReferenceBaseModel", path, "", res.getError());
				}
				return success("PortfolioReferenceBaseModel", ValidationType.CARDINALITY, "PortfolioReferenceBaseModel", path, "");
			})
			.collect(toList());
	}

}
