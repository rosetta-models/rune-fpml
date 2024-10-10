package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.InitialMargin;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Repo;
import fpml.confirmation.RepoDurationEnum;
import fpml.confirmation.RepoFarLeg;
import fpml.confirmation.RepoNearLeg;
import fpml.confirmation.RepoSequence;
import fpml.confirmation.Schedule;
import fpml.confirmation.TriParty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoValidator implements Validator<Repo> {

	private List<ComparisonResult> getComparisonResults(Repo o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRateSchedule", (Schedule) o.getFixedRateSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateCalculation", (FloatingRateCalculation) o.getFloatingRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("duration", (RepoDurationEnum) o.getDuration() != null ? 1 : 0, 0, 1), 
				checkCardinality("repoSequence", (RepoSequence) o.getRepoSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMargin", (InitialMargin) o.getInitialMargin() != null ? 1 : 0, 0, 1), 
				checkCardinality("nearLeg", (RepoNearLeg) o.getNearLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("farLeg", (RepoFarLeg) o.getFarLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("triParty", (TriParty) o.getTriParty() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Repo> validate(RosettaPath path, Repo o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Repo", ValidationType.CARDINALITY, "Repo", path, "", error);
		}
		return success("Repo", ValidationType.CARDINALITY, "Repo", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repo o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Repo", ValidationType.CARDINALITY, "Repo", path, "", res.getError());
				}
				return success("Repo", ValidationType.CARDINALITY, "Repo", path, "");
			})
			.collect(toList());
	}

}
