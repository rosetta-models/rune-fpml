package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Repo;
import fpml.confirmation.validation.RepoTypeFormatValidator;
import fpml.confirmation.validation.RepoValidator;
import fpml.confirmation.validation.exists.RepoOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Repo.class)
public class RepoMeta implements RosettaMetaData<Repo> {

	@Override
	public List<Validator<? super Repo>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Repo>create(fpml.confirmation.validation.datarule.RepoChoice.class),
			factory.<fpml.confirmation.Repo>create(fpml.confirmation.validation.datarule.RepoChoice.class),
			factory.<fpml.confirmation.Repo>create(fpml.confirmation.validation.datarule.RepoChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Repo, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Repo> validator() {
		return new RepoValidator();
	}

	@Override
	public Validator<? super Repo> typeFormatValidator() {
		return new RepoTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Repo, Set<String>> onlyExistsValidator() {
		return new RepoOnlyExistsValidator();
	}
}
