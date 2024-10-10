package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MatchId;
import fpml.confirmation.ProposedMatchModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProposedMatchModelValidator implements Validator<ProposedMatchModel> {

	private List<ComparisonResult> getComparisonResults(ProposedMatchModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("matchId", (MatchId) o.getMatchId() != null ? 1 : 0, 0, 1), 
				checkCardinality("matchScore", (BigDecimal) o.getMatchScore() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ProposedMatchModel> validate(RosettaPath path, ProposedMatchModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProposedMatchModel", ValidationType.CARDINALITY, "ProposedMatchModel", path, "", error);
		}
		return success("ProposedMatchModel", ValidationType.CARDINALITY, "ProposedMatchModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProposedMatchModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProposedMatchModel", ValidationType.CARDINALITY, "ProposedMatchModel", path, "", res.getError());
				}
				return success("ProposedMatchModel", ValidationType.CARDINALITY, "ProposedMatchModel", path, "");
			})
			.collect(toList());
	}

}
